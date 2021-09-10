import express, { request, Request, Response} from 'express'
import morpheus from './routes/morpheus'

const app = express()

app.use('/api', morpheus)


app.listen(4000, () => console.log("server started on 4000"))