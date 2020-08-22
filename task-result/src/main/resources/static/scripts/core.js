$(function(){
	$.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
	$.datepicker.setDefaults( {
        numberOfMonths: 3
        //,showButtonPanel: true 
        ,showOtherMonths: true
        ,selectOtherMonths: true
        ,dateFormat:"yy/mm/dd"
        ,changeMonth: true
        ,changeYear: true
      }	);
	$(".calendar").datepicker({
		  onSelect: function() {
			    $(this).change();
			  }
			});
	
	//disable jqgrid sort
	//https://stackoverflow.com/questions/8126712/jqgrid-disable-sorting
	//https://stackoverflow.com/questions/7148061/disable-sorting-in-jqgrid
	$.jgrid.defaults.cmTemplate={ sortable: false };

});


$.fn.addRows = function(data) {
	if (arguments.length > 1){
		data = Array.prototype.slice.call(arguments);
	}else{
		if (typeof(data.forEach) === "undefined"){
			data = [data];
		}
	}
	var $grid = $(this);
	data.forEach(function(d){
		var id = $.jgrid.randId();
		//https://stackoverflow.com/questions/6466350/problem-after-adding-row-in-jqgrid
		$grid.addRowData(id,d);
		$grid.jqGrid('editRow', id, false);
		//https://stackoverflow.com/questions/25364305/jqgrid-inlineedit-enter-key-does-not-trigger-aftersavefunc-event
		//http://www.trirand.net/documentation/php/_2va196tc2.htm
		//http://www.trirand.com/jqgridwiki/doku.php?id=wiki:inline_editing
	});
/*	
	var $this = jQuery('#list'), ids = $this.jqGrid('getDataIDs'), i, l = ids.length;
    for (i = 0; i < l; i++) {
        $this.jqGrid('editRow', ids[i], false);
    };
*/
};

$.fn.getRows = function() {
	var $grid = $(this);		
	var ids = $grid.jqGrid('getDataIDs');
	ids.forEach(function(id){
		$grid.jqGrid('saveRow', id, false, 'clientArray');
	});
	var data = $("#list").getRowData();
	ids.forEach(function(id){
		$grid.jqGrid('editRow', id, false);
	});
	return data;
};

$.fn.setRows = function(data) {
	var $grid = $(this);		
	$grid.clearGridData();
	$grid.addRows(data);		        
};

$.fn.setColumnValue = function(name,value) {
	var $grid = $(this);
	var rows = $grid.getRows();
	rows.forEach(function(row){
		row[name]=value;
	});
	$grid.setRows(rows);		        
};


