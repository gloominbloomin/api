import express, { request, Request, Response} from 'express'
import morpheus from './routes/morpheus'

const app = express()

app.use('/api', morpheus)


app.listen(8080, () => console.log("server started on 8080"))