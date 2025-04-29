//自定义对象：
var user = {
  name: "Tom",
  age: 20,
  gender: "male",
  eat() {
    console.log("吃饭");
  },
};

console.log(user.name);
user.eat;

//JSON:语法简单 层次鲜明 多用于数据载体 前后端数据的传输
//定义JSON
var userStr = '{"name":"Jerry", "age":18, "addr":["北京", "上海", "西安"]}';
//JSON转换成JS对象方法：
var obj = JSON.parse(userStr);
alert(obj.name);
//JSON对象转为JS字符串
alert(JSON.stringify(obj));

//BOM对象：浏览器对象模型：*window navigator screen history *location
//1.Window对象：
//1.1
window.alert("Hello BOM");
//1.2弹出确认框 选择取消或确认 返回值会返回true(确认) false(取消)
confirm("您确认删除吗？");
//1.3 周期性执行某一函数
var i = 0;
setInterval(function () {
  alert(++i);
}, 2000); //2s执行一次
//1.4 延迟指定时间执行一次 **只会执行1次**
setTimeout(function () {
  alert("JS");
}, 2000);
//2.Location对象：
//2.1设置或返回设定的URL
alert(location.href);
location.href = "https://www.sym.cn"; //会自动跳转到这个域名

//DOM：文档对象模型：Document Element Attribute Text Comment
//JS通过DOM对HTML进行操作
//根据ID/标签/name/class获取元素对象：
document.getElementById();
document.getElementsByTagName;
document.getElementsByName;
document.getElementsByClassName;
//修改内容
var divs = document.getElementsByName("tittle");
var div1 = divs[0];

div1.innerHTML = "sym666"; //用此方法直接修改html内容

//JS事件监听
//事件：按钮被点击 鼠标移动到元素上 表单被提交。。。。。
document.getElementsByName("1").onclick = function () {
  alert("我被点击了");
};

//Vue:前端框架 来免除原生DOM操作 简化书写 基于MVVM 实现数据的双向绑定
//Ajax:异步的JS和XML 作用：数据交换（给服务器发送请求 获取服务器响应的数据）、异步交互（在不重新加载整个页面的情况下，与服务器交换数据并更新部分网页 eg：搜索联想 用户名是否可用的校验）
//异步：客户端在服务器处理过程中可以继续访问操作其他内容
//同步：客户端要等待服务端处理完毕 再操作
