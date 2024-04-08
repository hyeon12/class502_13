const todo = {
  id: 1,
  data: [], // 스케줄 데이터 ...문자열로만 가능하기 때문에 []
  init() {
    // 초기 저장 값 조회 -> 스케줄 완성
    const jsonData = localStorage.getItem("todos");
    const todos = jsonData ? JSON.parse(jsonData) : []; //없을때 기본=빈 값

    const itemsEl = document.querySelector(".items");

    for (const item of todos) {
      // Symbol.iterator / 반복자 패턴 / 반복이 필요한 객체
      const liEl = this.getItem(item.title);
      itemsEl.appendChild(liEl);
    }
  },

  /** 설명용 주석
   * 스케줄 추가
   *
   */
  add() {
    const subject = frmRegist.subject.value; //value 값 = 사용자가 입력한 값
    
    if (!subject.trim()) {
      //좌우 공백 제거
      alert("할일을 입력하세요.");
      return;
    }

    const itemsEl = document.querySelector(".items");
    const liEl = this.getItem(subject);
    itemsEl.appendChild(liEl);

    frmRegist.subject.value = "";
    frmRegist.subject.focus();

    const { data } = this;
    let id = this.id++; // this 값 먼저 대입 후, 증가
    data.push({
      id,
      title: subject,
    });

    this.save();
  },
  save() {
    //로컬스토리지에 저장
    localStorage.setItem("todos", JSON.stringify(this.data));
  },
  getItem(subject) {
    const liEl = document.createElement("li");
    liEl.appendChild(document.createTextNode(subject));

    const buttonEl = document.createElement("button");
    buttonEl.appendChild(document.createTextNode("삭제"));
    liEl.appendChild(buttonEl);

    // 스케줄 삭제
    buttonEl.addEventListener("click", function () {
      const itemsEl = document.querySelector(".items");
      itemsEl.removeChild(liEl);
    });

    return liEl;
  },
};

window.addEventListener("DOMContentLoaded", function () {
  todo.init(); // 데이터 조회 및 완성... DOM이 완성되면 최초로...

  frmRegist.addEventListener("submit", function (e) {
    e.preventDefault();
    todo.add(); // 스케줄 추가
  });
});
