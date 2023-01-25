import { Button } from '@mui/material';
import React, { useState } from 'react';

const Komitenti = () => {
    const [measurements, setMeasurements] = useState([]);
    const [open, setOpen] = useState(false);
    const [loaded, setLoaded] = useState(false);
    
    
    return (
        <div style={{ padding: '25px' }}>
            <h2>Komitenti</h2>
            <p>Seznam vseh odprtih komitentov.</p>
            <Button variant="contained">Dodaj Komitenta</Button>
            <br />
            <br />
            
        </div>
    );
}

export default Komitenti;