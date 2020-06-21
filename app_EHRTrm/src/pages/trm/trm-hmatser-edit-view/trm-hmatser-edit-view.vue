<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmHmatserEditViewBase from './trm-hmatser-edit-view-base.vue';

import view_form from '@widgets/trm-hmatser/main-form/main-form.vue';

/**
 * 班主任编辑视图
 *
 * @export
 * @class TrmHmatserEditView
 * @extends {TrmHmatserEditViewBase}
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
export default class TrmHmatserEditView extends TrmHmatserEditViewBase { }
</script>