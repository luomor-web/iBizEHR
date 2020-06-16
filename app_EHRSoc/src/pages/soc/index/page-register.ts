export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('soc-rule-detail-edit-view', () => import('@pages/soc/soc-rule-detail-edit-view/soc-rule-detail-edit-view.vue'));
        Vue.component('soc-rule-grid-view', () => import('@pages/soc/soc-rule-grid-view/soc-rule-grid-view.vue'));
        Vue.component('soc-account-edit-view', () => import('@pages/soc/soc-account-edit-view/soc-account-edit-view.vue'));
        Vue.component('soc-type-edit-view', () => import('@pages/soc/soc-type-edit-view/soc-type-edit-view.vue'));
        Vue.component('orm-org-pickup-grid-view', () => import('@pages/orm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'));
        Vue.component('soc-type-grid-view', () => import('@pages/soc/soc-type-grid-view/soc-type-grid-view.vue'));
        Vue.component('orm-org-pickup-view', () => import('@pages/orm/orm-org-pickup-view/orm-org-pickup-view.vue'));
        Vue.component('soc-rule-detail-grid-view', () => import('@pages/soc/soc-rule-detail-grid-view/soc-rule-detail-grid-view.vue'));
        Vue.component('soc-type-pickup-view', () => import('@pages/soc/soc-type-pickup-view/soc-type-pickup-view.vue'));
        Vue.component('soc-type-pickup-grid-view', () => import('@pages/soc/soc-type-pickup-grid-view/soc-type-pickup-grid-view.vue'));
        Vue.component('soc-account-grid-view', () => import('@pages/soc/soc-account-grid-view/soc-account-grid-view.vue'));
        Vue.component('soc-area-grid-view', () => import('@pages/soc/soc-area-grid-view/soc-area-grid-view.vue'));
        Vue.component('soc-area-edit-view', () => import('@pages/soc/soc-area-edit-view/soc-area-edit-view.vue'));
        Vue.component('soc-rule-edit-view', () => import('@pages/soc/soc-rule-edit-view/soc-rule-edit-view.vue'));
    }
};