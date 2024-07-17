const todos = {
    // 스케줄 추가
    add(todo){
        
    }
};

window.addEventListener("DOMContentLoaded", function(){
    //submit 이벤트가 발생했을 때~
    frmTodo.addEventListener("submit", function(e){
        e.preventDefault();
         //제출-> 페이지 이동하며 데이터가 전달되는 것(기본동작)
         //이동해버리면? 동적으로 추가 x

        const todoEl = this.todo;
        //이벤트 발생한 요소 = this(frmTodo)
        //this.todo => frmTodo.todo (input)
        console.log(todoEl.value);
    });
});