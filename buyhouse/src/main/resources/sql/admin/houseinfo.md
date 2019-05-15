	
queryByCondtion
===
	 select u.*from house_info u where 1=1
    @if(!isEmpty(urban)){
        and u.urban = #urban#
    @}
     @if(!isEmpty(name)){
        and name like #"%"+name+"%"#
    @}
      @if(!isEmpty(room)&&room==5){
        and u.room >=#room#
    @}
     @if(!isEmpty(room)&&room<5){
        and u.room =#room#
    @}
     @if(!isEmpty(price)&&price==250){
        and u.price >250
    @}
     @if(!isEmpty(price)&&price<250){
        and u.price between #price# and #price#+50
    @}
       @if(!isEmpty(size)&&size==200){
        and u.size >200
    @}
     @if(!isEmpty(size)&&size<200){
        and u.size between #size# and #size#+30
    @}
    order by u.id DESC
    