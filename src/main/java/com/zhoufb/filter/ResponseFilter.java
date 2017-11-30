package com.zhoufb.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.interception.jaxrs.ContainerResponseContextImpl;
import org.jboss.resteasy.plugins.server.netty.NettyHttpResponse;

import com.suneee.resteasy.dto.PageDto;
import com.suneee.resteasy.util.HtmlCacheUtils;
import com.suneee.resteasy.util.HtmlUtils;
import com.suneee.resteasy.util.UriUtils;

/**
 * Created by Administrator on 2017/6/6.
 */
@Provider
public class ResponseFilter implements ContainerResponseFilter{

	public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException{

		String path = req.getUriInfo().getPath();
		//添加跨域支持
		res.getHeaders().add("Access-Control-Allow-Origin", "*");
		res.getHeaders().add("Access-Control-Allow-Headers", "x-requested-with,content-type,sessionid");
		res.getHeaders().add("Access-Control-Allow-Methods", "GET,POST,HEAD,PUT,DELETE,OPTIONS");

		/**
		 * 判断是文件则将其提供下载
		 * */
		if (res.getEntity() instanceof  File){
			NettyHttpResponse nettyHttpResponse = getNettyHttpResponse(res);
			if (nettyHttpResponse==null)return;
			File file = (File) res.getEntity();
			if (file.isFile()){
				nettyHttpResponse.downloadFile(file);
			}
		}else if (UriUtils.isStaticUri(path)||UriUtils.isStaticType(path)){
			NettyHttpResponse nettyHttpResponse = getNettyHttpResponse(res);
			if (nettyHttpResponse==null)return;

			if (UriUtils.isIndex(path)){
				path = "/static/login.html";
			}else if (!UriUtils.isStaticUri(path)){
				path = "/static"+path;
			}

			//添加cookie范例
			/*NewCookie cookie = new NewCookie("ab","123456789");
            nettyHttpResponse.addNewCookie(cookie);*/
			String runMode = System.getProperty("runMode");
			if (runMode!=null&&runMode.equals("develop")){
				deploy(path,nettyHttpResponse);
			}else {
				produce(path,nettyHttpResponse);
			}
			/*PageDto pageDto = HtmlCacheUtils.get(cachePath);
            if (pageDto == null){
                InputStream is=this.getClass().getResourceAsStream(path);
                pageDto = HtmlCacheUtils.add(path,is);
                if (pageDto == null){
                    nettyHttpResponse.sendError(404,"not found");
                    return;
                }
            }
            nettyHttpResponse.send(pageDto.getBytes());*/
			/*
            if (pageDto.getType() != null){
                switch (pageDto.getType().getFormat()){
                    case TEXT:nettyHttpResponse.send(pageDto.getBytes());break;
                    case IMAGE:nettyHttpResponse.send(pageDto.getBytes());
                }
            }*/
		}



	}
	private void deploy(String path,NettyHttpResponse nettyHttpResponse) throws FileNotFoundException {
		String targetPath = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1);
		String rootPath = targetPath.substring(0,targetPath.lastIndexOf("/target"));
		path = rootPath+"/src/main/resources"+path;

		File file = new File(path);
		if (!file.exists()){
			throw new FileNotFoundException("not file");
		}
		InputStream is= new FileInputStream(file);
		byte[] bytes = HtmlUtils.getByteForFile(is);
		nettyHttpResponse.send(bytes);
	}

	private void produce(String path,NettyHttpResponse nettyHttpResponse) throws IOException {
		PageDto pageDto = HtmlCacheUtils.get(path);
		if (pageDto == null){
			InputStream is=this.getClass().getResourceAsStream(path);
			pageDto = HtmlCacheUtils.add(path,is);
			if (pageDto == null){
				nettyHttpResponse.sendError(404,"not found");
				return;
			}
		}
		nettyHttpResponse.send(pageDto.getBytes());
	}

	private NettyHttpResponse getNettyHttpResponse(ContainerResponseContext res){
		if (res instanceof ContainerResponseContextImpl){
			ContainerResponseContextImpl responseContext = (ContainerResponseContextImpl) res;
			if (responseContext.getHttpResponse() instanceof NettyHttpResponse) {
				return (NettyHttpResponse) responseContext.getHttpResponse();
			}else {
				return null;
			}
		}
		return null;
	}
}
