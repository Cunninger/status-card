# 技术
- 后端：
    - Springboot
    - 正则表达式
    - HttpClient
- 前端：
    - Vue
# 界面
![image](https://github.com/Cunninger/status-card/assets/113076850/fd564aeb-fcae-434a-a036-ffadeb5b328e)


# 效果图
![image](https://github.com/Cunninger/status-card/assets/113076850/b4e1abda-8d38-4e6f-9f91-1a62c714b96d)



# 快速部署
## 本地部署
- 前端使用Vue框架，在`main.js`中配置访问后端路径。
```java
app.config.globalProperties.$http = axios.create({
    baseURL: 'http://localhost:7788'// 改成自己的后端启动端口
    
})
```

## 服务器部署

- 后端
`maven` 打包正常流程
- 前端
    - 1.将上述`main.js`文件中的` baseURL: 'http://localhost:7788'` 改为服务器IP，端口改为前端运行端口(默认为5173)
      - 例如：`baseURL: 'http://0.0.0.0:5173'`
    - 2.`npm run build`打包前端项目，生成 `dist` 文件
    - 3.配置`Nginx`代理,参考如下
```
server {
  listen 5173;// 前端项目运行端口
  server_name 服务器IP;

  location / {
      alias /A_myProject/JavaProject/status-card/statuscardfore/dist/;// 服务器中前端dist目录
      try_files $uri $uri/ /index.html;
      index index.html index.htm;
  }

  location /api {
      proxy_pass http://localhost:7788;// 后端项目端口
      proxy_set_header x-forwarded-for $remote_addr;
  }
}
```

  
