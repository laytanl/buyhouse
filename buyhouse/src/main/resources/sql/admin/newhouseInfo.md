	
queryByCondtion
===
	 select u.* from newhouse_info u where 1=1
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
     @if(!isEmpty(price)&&price==14000){
        and u.price >14000
    @}
      @if(!isEmpty(price)&&price==0){
        and u.price <6000
    @}
     @if(!isEmpty(price)&&price<14000&&price>=6000){
        and u.price between #price# and #price#+2000
    @}
       @if(!isEmpty(size)&&size==200){
        and u.size >200
    @}
     @if(!isEmpty(size)&&size<200){
        and u.size between #size# and #size#+30
    @}
      @if(!isEmpty(style)){
        and u.style =#style#
    @}
    order by u.id DESC

    