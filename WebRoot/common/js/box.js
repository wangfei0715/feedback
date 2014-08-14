// JavaScript Document
var temp = 1;
function selectAll(i){	
    if(i == -1){
        $("input[type=checkbox]").each(function(i){
            this.checked = !this.checked;
        });
    }
    else{
        if(temp ==1){
            $("input[type=checkbox]").attr("checked",true);
            temp = 0;
        }
        else{
            $("input[type=checkbox]").attr("checked",false);
            temp = 1;
        }
    }
}