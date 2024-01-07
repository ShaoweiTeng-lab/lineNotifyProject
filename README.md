LINE 服務有一個 LINE Notify 帳號，這是一個 LINEBot 機器人，專門用來發送訊息的帳號，只要你曾經有訂閱任何一個 LINE Notify 通知服務，它就能發訊息給你；或是把 LINE Notify 帳號加入群組也可以。LINE Notify 可以讓開發人員免費的發送訊息 + 表情或是圖片給用戶，在需要即時的通知用戶的場景下，是一個相當實惠的解決方案；尤其在台灣 LINE 等於是一個基礎建設，人手都有帳號，用 LINE 整合訊息通知應該是比較方便的。


<H1>開發環境</H1>

* Spring boot 3.0

取得發送訊息的 Access Token

LINE 官方提供幾種方式可以讓開發人員用程式發送訊息:

1.Generate access token (For developers)

- 不需要個人授權

- 適用訊息發送給群組

2.建立通知服務

- 需要個人授權，OAuth2 流程

- 適用訊息發送給個人或群組

參考網站 : https://dotblogs.com.tw/yc421206/2021/07/14/via_line_notify_send_message_stiker_and_image
