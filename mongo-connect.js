function connectMongo(){
    const MongoClient = require('mongodb').MongoClient;
    console.log('MongoClient is',typeof MongoClient)
    let myCollection;
    const url = 'mongodb://127.0.0.1:27017/test';
    const db = MongoClient.connect(url, function (err, db) {
        if (err) {
            console.log("mongoerror", err);
            throw err;
        }
        console.log("connected to the mongoDB!");
        myCollection = db.collection('test_collection');
    });
}
connectMongo()