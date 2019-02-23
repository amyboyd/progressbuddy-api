const coachBob = {
    _id: new ObjectId(),
    name: 'Bob',
    bio: 'Bob has been working with Depaul since 2012. He studied medicine at UCL and now is a Senior Progression Coach in our Oldham center.',
    jobTitle: 'Senior Progression Coach',
    photo: '@todo',
};
db.coaches.insert(coachBob);

const clientClaire = {
    _id: new ObjectId(),
    name: 'Claire',
    phone: '07123123123',
    address: 'Depaul Oldham',
    coach: new DBRef('coaches', coachBob._id),
};
db.clients.insert(clientClaire);

db.users.insert({
    email: 'coach-bob@example.com',
    password: 'pass1234',
    coach: new DBRef('coaches', coachBob._id),
})

db.users.insert({
    email: 'client-claire@example.com',
    password: 'pass1234',
    client: new DBRef('clients', clientClaire._id),
})
