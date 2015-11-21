<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 12/13/2014
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Registration</h1>

<form method="post" action="filler">
    <table width="80%">
        <tr>
            <td><b>*Ім'я</b></td>
            <td><input type="text" name="name" maxlength="22" size="22"  required></td>
            <td><b>*Прізвище</b></td>
            <td> <input type="text" name="surname" maxlength="22" size="22"   required></td>
        </tr>
        <tr>


            <td><b>*Пароль </b></td>
            <td > <input type="text" name="password" maxlength="22" size="22"  required></td>
            <td><b>*Стать </b></td>
            <td > <input type="text" name="sex" maxlength="22" size="22"   required></td>
        </tr>
        <tr>
            <td><b>*Е-mail </b></td>
            <td> <input type="email" name="email" maxlength="22" size="22"   required></td>
            <td><b>Група </b></td>
            <td> <input type="number" name="groupNumber" maxlength="15" size="22"   /></td>
        </tr>


        <tr>
            <td><b>Країна </b></td>
            <td>
                <select name="country" id="country" accesskey="5">
                    <option value="ukraine" selected>Україна</option>
                    <option value="russia">Росія</option>
                    <option value="usa">США</option>
                    <option value="uk">Велика Британія</option>
                </select>
            </td>

            <td><b>Місто </b></td>
            <td > <input type="number" name="city" maxlength="22" size="22"   /></td>

        </tr>

        <tr>
            <td><b>Вік</b></td>
            <td><input type='number' name='birthday' value=''/>

        </tr>
        <tr> <td><br></td></tr>
        <tr>
            <td rows="3">
                <details>
                    <summary><b>Виберіть предмети</b></summary>
                    <p>Вкажіть предмети, які ви б бажали вивчати протягом навчання в нашому ВНЗ</p>
                </details></td>
        </tr>

        <tr>
            <td align="left"><input type="checkbox" name="subject" value="Subject1"> Вища математика</td>
            <td align="left"><input type="checkbox" name="subject" value="Subject2"> Комп'ютерні мережі </td>
            <td align="left"><input type="checkbox" name="subject" value="Subject3"> Основи ООП    </td>
            <td align="left"><input type="checkbox" name="subject" value="Subject4"> Бази даних    </td>
        </tr>
        <tr>
            <td align="left"><input type="checkbox" name="subject" value="Subject5"> Алгоритми програмування </td>
            <td align="left"><input type="checkbox" name="subject" value="Subject6"> Безпека інформації</td>
            <td align="left"><input type="checkbox" name="subject" value="Subject7"> Захист інформації</td>
            <td align="left"><input type="checkbox" name="subject" value="Subject8"> Основи програмування "Java"</td>
        </tr>
        <tr> <td><br></td></tr>
        <tr>
            <td><b>Зазначете кафедру</b></td>
        </tr>

        <tr>
            <td><input type="radio" name="info" value="Cafedra1"> КСЗІ</td>
            <td><input type="radio" name="info" value="Cafedra2"> БІТ</td>
            <td><input type="radio" name="info" value="Cafedra3"> ІПЗ</td>
            <td><input type="radio" name="info" value="Cafedra4"> КІТ</td>
        </tr>

        <tr>
            <td><input type="radio" name="info" value="Cafedra5"> КСІМ</td>
            <td><input type="radio" name="info" value="Cafedra6"> КСУ</td>
            <td><input type="radio" name="info" value="Cafedra7"> КМТ</td>
            <td><input type="radio" name="info" value="Cafedra8"> ВТОМ</td>
        </tr>

    </table>

    <b>Розкажіть про себе:</b> <br>
        <textarea rows=4 cols=45 name="aboutstudent">
        </textarea>
        <br>
        <b>Дата заповнення</b>
        <input type='date' name='date' value=''/>
        </br>
        <input type="submit" value="OK">
        <input type="reset" value="Cansel">


</form>
</body>
</html>
