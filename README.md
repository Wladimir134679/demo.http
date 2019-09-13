# Demo RestHTTP JSON-API

####Запрос

POST /visited_links
```
{
    "links":[  
        "https://ya.ru",
        "https://ya.ru?q=123",
        "funbox.ru",
        "https://stackoverflow.com/questions/11828270/how-to-exit-the-vim-editor"
    ]
}
```

###Ответ

```json
{
  "status":"ok"
}
```


####Запрос

GET /visited_domains?from=1545221231&to=1545217638
``` json
{
    "domains":[
        "ya.ru",
        "funbox.ru",
        "stackoverflow.com"
    ],
    "status":"ok"
}
```


