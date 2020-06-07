import { viewstate } from './state';
import * as actions from './actions';
import * as mutations from './mutations';
import * as getters from './getters';

const state = {
    ...viewstate
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}