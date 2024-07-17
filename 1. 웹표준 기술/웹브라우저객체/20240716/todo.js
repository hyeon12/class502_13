const todos = {
    // 스케줄 추가
    add(todo) {
        todo = todo ?? "";
        todo = todo.trim();
        if (!todo){
            throw new Error("스케줄을 입력하세요")
        }

        const button = document.createElement("button");
        button.append("삭제");

        const liEl = document.createElement("li");
        liEl.append(todo, button); 
        //append() 요소 추가, 여러개도 추가 가능!

        const schedulesEl = document.getElementById("schedules");
        schedulesEl.append(liEl);

        //스케줄 삭제
        //버튼(삭제) 클릭했을때, function 정의
        button.addEventListener("click", function(){
            if(confirm("정말 삭제하시겠습니까?")){
                liEl.remove(); 
                //document 객체에 remove() -> 요소지정 없이도 삭제 가능
            }
        });
    },
};

window.addEventListener("DOMContentLoaded", function(){
    frmRegist.addEventListener("submit", function(e){
        e.preventDefault();

        const todoEl = this.todo;

        try{
            todos.add(todoEl.value); //스케줄 등록

            todoEl.value = ""; //스케줄 등록 끝나면 초기화
        }catch (e){
            alert(e.message);
        }

        todoEl.focus(); //다시 입력하도록 포커스
    });

});
