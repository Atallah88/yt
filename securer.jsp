<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ar">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Your Profile</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fc;
            color: #333;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h1 {
            color: #4CAF50;
            font-size: 36px;
        }

        p {
            font-size: 18px;
            margin: 20px 0;
        }

        .welcome-message {
            font-size: 20px;
            color: #4CAF50;
            font-weight: bold;
        }

        .button {
            padding: 15px 30px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #0056b3;
        }

        .footer {
            font-size: 14px;
            color: #aaa;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <%  
            HttpSession ses = request.getSession(false);  // الحصول على الجلسة الحالية

            if(ses != null && ses.getAttribute("name") != null){ // تحقق من وجود الجلسة واسم المستخدم
                String name = (String) ses.getAttribute("name");  // استرجاع اسم المستخدم
        %>

        <h1>مرحبًا بك في ملفك الشخصي</h1>
        <p class="welcome-message">أهلاً، <%= name %>! <br>نحن سعداء لوجودك معنا.</p>
        <p>يمكنك الآن تصفح المنتجات المتوفرة لدينا.</p>
        <a href="products.html" class="button">انتقل إلى المنتجات</a>  <!-- رابط إلى صفحة المنتجات -->
        
        <% 
            } else {  // في حال لم يكن المستخدم قد سجل الدخول
        %>
        
        <h1>مرحبًا بك</h1>
        <p>يرجى تسجيل الدخول أولاً للاستفادة من خدماتنا.</p>
        <a href="login.html" class="button">تسجيل الدخول</a>  <!-- رابط إلى صفحة تسجيل الدخول -->
        
        <% 
            }
        %>
    </div>

    <div class="footer">
        <p>&copy; 2025 جميع الحقوق محفوظة</p>
    </div>
</body>
</html>
