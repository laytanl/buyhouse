package com.csuft.buyhouse.util;
/**
 * 
 * @content: 文件实体描述 <br/>  
 * @date: 2018年12月29日 上午9:15:24 <br/>  
 * @email: xingchun.wang@tcl.com
 * @author: Administrator  
 * @version:   
 * @since: JDK 1.8
 */
public class FastDFSFile {
	//文件名称
	private String name;
	//文件大小
	private byte[] content;
	//文件路径
	private String ext;
	//加密码
	private String md5;
	//作者
	private String author;

	public FastDFSFile(String name, byte[] content, String ext, String height,
					   String width, String author) {
		super();
		this.name = name;
		this.content = content;
		this.ext = ext;
		this.author = author;
	}

	public FastDFSFile(String name, byte[] content, String ext) {
		super();
		this.name = name;
		this.content = content;
		this.ext = ext;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}