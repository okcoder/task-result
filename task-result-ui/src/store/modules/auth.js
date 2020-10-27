export default {
    namespaced: true,
    state: {
        tenant: '',
        userId: '',
        token: '',
        menus: []
    },
    mutations: {
        create(state, data) {
            state.tenant = '';
            state.token = data.token;
            state.userId = data.userId;
            state.menus = data.menus;
        },
        destroy(state) {
            state.tenant = '';
            state.userId = '';
            state.token = '';
            state.menus = '';
        }
    },
    actions: {
        create({ commit, dispatch }, data) {
            dispatch(
                'http/post',
                { url: '/auth', data, error: 'message.unauthorized' },
                { root: true }
            ).then(res => commit('create', res.data))
                .catch(err => err)
        },
        destroy({ commit }) {
            commit('destroy', {});
            /*dispatch(
                'http/delete',
                { url: '/auth', data },
                { root: true }
            ).then(res => commit('create', res.data))
                .catch(err => err)
                // logout anyway ...
                .finally(res => commit('destroy', res.data))
                */
        }
    }
}