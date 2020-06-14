<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbmxKHEditViewBase from './par-ldndlhmbmx-khedit-view-base.vue';

import view_form from '@widgets/par-ldndlhmbmx/ndlhmbkhmx-jzszps-form/ndlhmbkhmx-jzszps-form.vue';

/**
 * 量化目标明细考核
 *
 * @export
 * @class ParLdndlhmbmxKHEditView
 * @extends {ParLdndlhmbmxKHEditViewBase}
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
export default class ParLdndlhmbmxKHEditView extends ParLdndlhmbmxKHEditViewBase { }
</script>