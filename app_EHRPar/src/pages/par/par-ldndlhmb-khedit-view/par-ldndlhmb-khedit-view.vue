<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbKHEditViewBase from './par-ldndlhmb-khedit-view-base.vue';

import view_form from '@widgets/par-ldndlhmb/ndlhmbkh-form/ndlhmbkh-form.vue';

/**
 * 量化目标考核（公司领导类）
 *
 * @export
 * @class ParLdndlhmbKHEditView
 * @extends {ParLdndlhmbKHEditViewBase}
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
export default class ParLdndlhmbKHEditView extends ParLdndlhmbKHEditViewBase { }
</script>