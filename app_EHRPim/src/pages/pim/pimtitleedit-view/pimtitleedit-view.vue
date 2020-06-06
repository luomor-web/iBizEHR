<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLEEditViewBase from './pimtitleedit-view-base.vue';

import view_form from '@widgets/pim-title/main-form/main-form.vue';

/**
 * 职称信息编辑视图
 *
 * @export
 * @class PIMTITLEEditView
 * @extends {PIMTITLEEditViewBase}
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
export default class PIMTITLEEditView extends PIMTITLEEditViewBase { }
</script>