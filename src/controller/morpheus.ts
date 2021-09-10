import express, { Request, Response} from 'express'

export const get = (req: Request, res: Response) => {
    res.status(200).json({message: "Hello World"})
}

export const set = (req: Request, res: Response) => {
    const { data } = req.body

    res.status(200).json({message: data})
}