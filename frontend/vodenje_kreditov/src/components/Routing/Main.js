import React from 'react';
import { Routes, Route } from "react-router-dom";
import Komitenti from '../Komitenti/Komitenti';
import PageNotFound from "../PageNotFound/PageNotFound";
import Krediti from '../Krediti/Krediti';

const Main = () => {
    return (
        <Routes>
            <Route path="/" element={<Komitenti />} />
            <Route path="/krediti" element={<Krediti />} />
            <Route path="*" element={<PageNotFound />} />
        </Routes>
    );
}

export default Main;