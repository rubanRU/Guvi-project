<html>
<head>
    <style>
         input.submit
            {
                 font-size:22px;
}
body{
    background-image: url("66.jpg");

}
        div{
          
            text-align: center;
}
        h1{
            text-align:center;
           
}
input.kk{
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

  function test(str)
  {
   var ob=new XMLHttpRequest();

   ob.onreadystatechange=function ss()
   {
    if(ob.readyState==4)
    {
        document.getElementById("s1").innerHTML=ob.responseText;
    }
   }

   ob.open("GET","RDemo4?msg="+str,true);
   ob.send();
  }

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
         CHECK DOCTOR AVALIABLE ARE NOT
     </h1>
     
  <form name="f1"  action="" class="kk">
     ENTER YOUR HEALTH PROBLEM TO CONSULT:   <input type="text" name="user" onkeyup="test(this.value);" />
              
  </form>
     <form action="wec.html" class="submit">
         <input type="submit" value="NEXT"/>

     </form>

     <div id="s1">

     </div>
 </body>
</html>
