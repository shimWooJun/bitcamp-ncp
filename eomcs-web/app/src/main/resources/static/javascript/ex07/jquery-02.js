function Jquery(selector) {
    if(selector.startsWith("<")){
        return document.createElement(selector.substring(1, selector.length - 1));
    }else {
        return document.querySelectorAll(selector);
    }
}

var $ = Jquery;

