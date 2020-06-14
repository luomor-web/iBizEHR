<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbNDLHMBXZEditViewBase from './par-ldndlhmb-ndlhmbxzedit-view-base.vue';

import view_form from '@widgets/par-ldndlhmb/ndlhmbxz-form/ndlhmbxz-form.vue';

/**
 * 量化目标修正
 *
 * @export
 * @class ParLdndlhmbNDLHMBXZEditView
 * @extends {ParLdndlhmbNDLHMBXZEditViewBase}
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
export default class ParLdndlhmbNDLHMBXZEditView extends ParLdndlhmbNDLHMBXZEditViewBase { }
</script>