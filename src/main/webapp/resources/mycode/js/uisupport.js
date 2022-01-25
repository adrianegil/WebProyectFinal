function refresh(){
   location.reload(true);
}

function start() { // info.xhtml
    PF('statusDialog').show();
}

function stop() { // info.xhtml
    PF('statusDialog').hide();
}

function exportAgeChart() { // patients.xhtml
   if(isOperaBrowser()){
       alert('Esta función no está habilitada para navegadores Opera. Por favor, inténtelo con otro navegador. (Ej: Internet Explorer, Mozilla Firefox, Google Chrome...)');
   }else{
       $('.exportDlg').empty().append(PF('chartAge').exportAsImage());
       PF('dlg').show();
   }
}