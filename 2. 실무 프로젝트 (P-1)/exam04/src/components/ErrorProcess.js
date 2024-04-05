import { Component } from 'react';

class ErrorProcess extends Component {
  state = {
    isError: false, //에러 발생 여부
    message: '', //에러 메세지
  };

  componentDidCatch(error, info) {
    console.error(error, info);
    this.setState({ isError: true, message: error.message });
  }

  render() {
    const { isError, message } = this.state;
    const { children } = this.props;

    return isError ? <div>{message}</div> : children;
  }
}

export default ErrorProcess;
