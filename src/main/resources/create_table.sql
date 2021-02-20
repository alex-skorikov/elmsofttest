create table equation
(
    id           serial PRIMARY KEY,
    coefficienta real,
    coefficientb real,
    coefficientc real,
    discriminant real,
    rootfirst    real,
    rootsecond   real
)