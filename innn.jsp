<html>
    
    <head>
        <style>
  input.submit
            {
                 font-size:22px;
}
            form{
                color: red;
                font-size: 20px;
}
 h1{
     background-color: greenyellow;
     text-align: center;
}
h3{
    text-align: left
}

        </style>
        <script type="text/javascript">
            function t(){
                var exp2="^[0-9]*$";
                var p=document.f1.na.value;
                var o=document.f1.n.value;
                var l=document.f1.ch.value;
                if(l==""){
                    alert("PLEASE ENTER THE CHANGES") ;
                    f1.ch.focus();
                    return false;
                }
                if(p==""){
                    alert("PLEASE CHOOSE THE NUMBER") ;
                    f1.na.focus();
                    return false;
                }
                if(l.search(exp2)==-1)
                {
                   alert("Only numbers");
                    f1.ch.focus();
                   return false;
   }
                if(o==""){
                    alert("PLEASE ENTER THE NAME OF PATIENT") ;
                     f1.n.focus();
                    return false;
                }

                return true;
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
        <h1>
            ALTERATION FORM
        </h1>
        <h3>
        1-ID
        </h3>
        <h3>
        2-password
        </h3>
        <h3>
        3- GENDER
        </h3>
         <h3>
        4- STATUS
        </h3> <h3>
        5- CITY
        </h3>
        <pre>
        <form  name="f1" action="Rdm" method="get" onsubmit="return t();">
            CHOOSE NUMBER      <input type="text"name="na" value=""/> <br/>
            CHOOSE NAME       <input type="text"name="n" value=""/><br/>
            CHANGES           <input type="text" name="ch" value=""/><br/>
            <input type="submit" value="submit" class="submit"><br/>
        </form>
        </pre>
    </body>
</html>