<script lang='ts'>
import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '@/crm-core';
import IndexBase from './index-base.vue';

import view_appmenu from '@widgets/app/index-appmenu/index-appmenu.vue';

/**
 * EHR—薪酬管理
 *
 * @export
 * @class Index
 * @extends {IndexBase}
 */
@Component({
    components: {
        view_appmenu, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
@VueLifeCycleProcessing
export default class Index extends IndexBase { }
</script>