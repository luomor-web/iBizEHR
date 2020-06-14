<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbmxEditViewBase from './par-ldndlhmbmx-edit-view-base.vue';

import view_form from '@widgets/par-ldndlhmbmx/main-form/main-form.vue';

/**
 * 量化目标明细（公司领导类 ）
 *
 * @export
 * @class ParLdndlhmbmxEditView
 * @extends {ParLdndlhmbmxEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ParLdndlhmbmxEditView extends ParLdndlhmbmxEditViewBase { }
</script>