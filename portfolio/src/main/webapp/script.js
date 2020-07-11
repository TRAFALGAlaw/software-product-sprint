// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['崔胜澈！', '尹净汉！', '洪知秀！', '文俊辉！', '权顺荣！', '全圆佑！', '李知勋！', '徐明浩！', '金珉奎！', '李硕珉！', '夫胜宽！', '崔瀚率！', '李灿！'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function seeComments(){
    const response = await fetch('/data');
    const data = await response.json();
    document.getElementById('comment-container').innerText = data;
}
