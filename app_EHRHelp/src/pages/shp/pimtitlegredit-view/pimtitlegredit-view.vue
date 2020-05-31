<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLEGREditViewBase from './pimtitlegredit-view-base.vue';

import view_form from '@widgets/pim-title/main-2-form/main-2-form.vue';

/**
 * 职称信息编辑视图
 *
 * @export
 * @class PIMTITLEGREditView
 * @extends {PIMTITLEGREditViewBase}
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
export default class PIMTITLEGREditView extends PIMTITLEGREditViewBase { }
</script>