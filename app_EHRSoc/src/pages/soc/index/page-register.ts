export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('orm-org-pickup-view', () => import('@pages/orm/orm-org-pickup-view/orm-org-pickup-view.vue'));
        Vue.component('soc-account-grid-view', () => import('@pages/soc/soc-account-grid-view/soc-account-grid-view.vue'));
        Vue.component('soc-account-edit-view', () => import('@pages/soc/soc-account-edit-view/soc-account-edit-view.vue'));
        Vue.component('soc-area-grid-view', () => import('@pages/soc/soc-area-grid-view/soc-area-grid-view.vue'));
        Vue.component('orm-org-pickup-grid-view', () => import('@pages/orm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'));
        Vue.component('soc-area-edit-view', () => import('@pages/soc/soc-area-edit-view/soc-area-edit-view.vue'));
    }
};