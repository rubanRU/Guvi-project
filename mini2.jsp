<html>
    <head>
        <style>
            input.submit{
                 font-size: 22px;

}
            form{
                font-size: 22px;
}
            body{
                background-image:url("sub.jpg");

}
h1{
    
    text-align: center;
}

ul
{
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color:lightskyblue;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 16px 18px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: blue;
}

.active {
    background-color: darkslateblue;
}


        </style>
         <script type="text/javascript">

  function test()
  {
  var exp1="^[0-9]*$";
   if(document.f1.user.value=="")
   {
    alert("Enter the Username");
    f1.user.focus();
    return false;
   }
   if(document.f1.id.value==""){
       alert("Enter the id");
       f1.id.focus();
       return false;
   }
  if(document.f1.blo.value==""){
       alert("Enter the bloodgroup");
       f1.blo.focus();
       return false;
   }
   if(document.f1.id.value.search(exp1)==-1)
   {
     alert("ENTER ID ONLY NUMBERS NUMBERS");
     f1.id.focus();
     return false;
   }

   if(document.f1.pass.value=="")
   {
    alert("Enter the Password");
    f1.pass.focus();
    return false;
   }
if ((document.f1.gender[0].checked == false)&& (document.f1.gender[1].checked == false))
    {
        f1.gender[0].focus();
        alert ( "Please choose your Gender: Male or Female" );
        return false;
    }

    if ((document.f1.status[0].checked == false)&& (document.f1.status[1].checked == false))
    {
        f1.gender[0].focus();
        alert ( "Please choose your status: single or married" );
        return false;
    }

    if (document.f1.city.selectedIndex == 0 )
    {
        alert ( "Please select your City." );
        f1.city.focus();
        return false;
    }


   return true;
  }


  </script>
        <script src="jquery-1.11.3.min.js"></script>
<script>
$(document).ready(function(){
    $("input").focus(function(){
        $(this).css("background-color", "#FFEFD5");
    });
    $("input").blur(function(){
        $(this).css("background-color", "#FFFFFF");
    });
});
</script>
    </head>
    <body>
        <ul>
  <li><a class="active" href="http://localhost:8080/minip/fr.html">Home</a></li>
  <li><a  href="kri.html">News</a></li>
  <li><a href="kri1.html">Contact</a></li>
  <li><a href="kri2.html">About</a></li>
</ul>

        <h1>
            PATIENT DETAILS FORM
        </h1>
        <form name="f1" action="RDemo1" method="get" onsubmit="return test();">
<pre>
     USERNAME         <input type="text" name="user"  size="34" /><br />
     SET ID           <input type="text" name="id"  size="34"/><br/>
     SET PASSWORD     <input type="password" name="pass"  size="34"/><br />
     GENDER           <input type="radio" name="gender" value="male" />Male
                      <input type="radio" name="gender" value="female" />Female<br />
     BLOOD GROUP       <input type="text" name="blo"  size="34" /><br/>
     STATUS            <input type="radio" name="status" value="single" />single
                       <input type="radio" name="status" value="married" />married<br />
     CITY              <select name="city">
                      <option>Select</option>
                      <option value="cbe">Coimbatore</option>
                      <option value="chennai">Chennai</option>
                      <option value="salem">Vellore</option>
                      <option value="madurai">madurai</option>
                      <option value="trichy">trichy</option>
                      <option value="salem">salem</option>
                      <option value="others">others</option>
                      </select><br/>

                       <input type="submit" value="submit" class="submit" />
  </form>
        </pre>
    </body>
</html>