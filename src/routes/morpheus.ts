import express from 'express'
const router = express.Router()
import { morpheus } from '../controller'

router.get('/get',  morpheus.get)
router.post('/set', morpheus.get)

export default router;