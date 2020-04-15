/**
 * 
 */
$(document).ready(function(){
   
    $('#pass2').keyup(()=>{
        passwordMacth()
    })
    $('#reference').focusout(()=>{
		checkRef()
	})
})

function passwordMacth(){
    var pass1 = $('#pass1').val() 
    var pass2 = $('#pass2').val() 
        
         if(pass1 != pass2){
             $('#pwd_err').addClass("text-danger")
             $('#pwd_err').removeClass("text-success")
             $('#pwd_err').html("mot de passe de confirmation non correspondant ! ")
         }else{
             $('#pwd_err').removeClass("text-danger")
             $('#pwd_err').addClass("text-success")
             $('#pwd_err').html("validé")
         }
}

function checkRef(){
	var ref= $('#reference').val()
	
	$.ajax({
		method : "get",
		url : "/gse/responsables/checkRef/"+ref,
		dataType : "json",
		contentType : "application/json",
		success : function(data){
            
			if(data != null){
				$('#reference').focus()
				$('#ref_err').html("Référence activité existant ")
			}
			else{
				$('#ref_err').html("")
			}
		},
		error : function(){
			console.log("error")
		}
	})
}

/* ############################################################################################################### */
/* 
## ** Ilay Tiako ** ##
 

/*
    Tony ny fo,
    Ventso ny fanahy,
    Fa manana olotiana,
    Mitsimbina ny AHY
    
    Sambatra aok'izany
    Manembonembona ny farihy,
    Izato izy tô tsindrindoana,
    Rah iny Mijanjy Ifanihy

    Mahatoky, manantena,
    Ilay maraina vao
    No Indro mody ilay masoandro
    Ho aiza re izaho ? 


    
*/