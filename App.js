import React, { Component } from 'react';
import {
  AppRegistry,
  SafeAreaView,

  Text,
} from 'react-native';


import FullScreen from './FullScreenModule'

export default class App extends Component {
  
  constructor(props){
    super(props)
    this.state = {
      asdf:''
    }
    


  }
  componentDidMount() {
    
    setTimeout(() => {
      FullScreen.hideBar()
    }, 2000);
  }
  render() {


    

    return (
      <SafeAreaView style={{backgroundColor:'white', flex:1}} >
        <Text>OLDU BE SONUNDA</Text>
      </SafeAreaView>
    );
  }

};

AppRegistry.registerComponent('App', () => App)