<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLEWSSEditViewBase from './pimtitlewssedit-view-base.vue';

import view_form from '@widgets/pim-title/main-3-form/main-3-form.vue';

/**
 * 职称信息编辑视图
 *
 * @export
 * @class PIMTITLEWSSEditView
 * @extends {PIMTITLEWSSEditViewBase}
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
export default class PIMTITLEWSSEditView extends PIMTITLEWSSEditViewBase { }
</script>