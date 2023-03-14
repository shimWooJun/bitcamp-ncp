"use strict"
console.log("시작됨!");



// 좋아요 버튼 리액츠 컴포넌트 정의
class LikeButton extends React.Component {
    constructor(props){
    super(props);
    this.state = {
        liked: false,
    };
    }


    render() {
        if (this.state.liked) {
            return "좋아합니다!";
        }
        return (
            <button onClick={()=> this.setState({liked: true})}>좋아요</button>
        );
    }
}

document.querySelectorAll(".like-container").forEach(likeContainer => {
    const root = ReactDOM.createRoot(likeContainer);
    root.render(React.createElement(LikeButton));
});
console.log("종료됨!");