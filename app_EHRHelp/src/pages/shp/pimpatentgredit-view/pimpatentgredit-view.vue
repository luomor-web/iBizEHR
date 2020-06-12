<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPATENTGREditViewBase from './pimpatentgredit-view-base.vue';

import view_form from '@widgets/pim-patent/grpatent-edit-form-form/grpatent-edit-form-form.vue';

/**
 * 专利信息编辑视图
 *
 * @export
 * @class PIMPATENTGREditView
 * @extends {PIMPATENTGREditViewBase}
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
export default class PIMPATENTGREditView extends PIMPATENTGREditViewBase { }
</script>