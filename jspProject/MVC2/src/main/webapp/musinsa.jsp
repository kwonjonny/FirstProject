<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>무신사 배경 이미지와 로그인창</title>
    <style>
      /* 배경 이미지 적용 */
      body {
        background-image: url("배경이미지주소.jpg");
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
      }

      /* 로그인창 스타일 적용 */
      .login {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        border: 1px solid #ddd;
        padding: 20px;
        width: 300px;
      }

      .login input[type="text"],
      .login input[type="password"] {
        display: block;
        width: 100%;
        margin-bottom: 10px;
        padding: 10px;
        border: 1px solid #ddd;
      }

      .login input[type="submit"] {
        background-color: #000;
        color: #fff;
        border: none;
        padding: 10px;
        width: 100%;
        cursor: pointer;
      }

      .login input[type="submit"]:hover {
        background-color: #fff;
        color: #000;
      }
    </style>
  </head>
  <body>
    <div class="login">
      <form>
        <input type="text" placeholder="아이디" />
        <input type="password" placeholder="비밀번호" />
        <input type="submit" value="로그인" />
      </form>
    </div>
  </body>
</html>
    