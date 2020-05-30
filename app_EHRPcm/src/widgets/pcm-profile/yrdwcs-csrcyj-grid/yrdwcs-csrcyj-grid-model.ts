/**
 * YRDWCS_CSRCYJ 部件模型
 *
 * @export
 * @class YRDWCS_CSRCYJModel
 */
export default class YRDWCS_CSRCYJModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof YRDWCS_CSRCYJGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof YRDWCS_CSRCYJGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'gwlb',
          prop: 'gwlb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'rzqd',
          prop: 'rzqd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'xkml',
          prop: 'xkml',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xznf',
          prop: 'xznf',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmstag',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmprofilename',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'pcmprofileid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmprofileid',
          dataType: 'GUID',
        },
        {
          name: 'ormdutyid',
          prop: 'ormdutyid',
          dataType: 'PICKUP',
        },
        {
          name: 'certificatenumber',
          prop: 'certificatenumber',
          dataType: 'TEXT',
        },
        {
          name: 'gender',
          prop: 'gender',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmprofilename',
          prop: 'pcmprofilename',
          dataType: 'TEXT',
        },
        {
          name: 'yglx',
          prop: 'yglx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmprofileid',
          prop: 'pcmprofileid',
          dataType: 'GUID',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'xxxz',
          prop: 'xxxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'educationlevel',
          prop: 'educationlevel',
          dataType: 'SSCODELIST',
        },
        {
          name: 'cz2',
          prop: 'cz2',
          dataType: 'TEXT',
        },
        {
          name: 'profiletype',
          prop: 'profiletype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'email',
          prop: 'email',
          dataType: 'TEXT',
        },
        {
          name: 'r_lastschool',
          prop: 'r_lastschool',
          dataType: 'TEXT',
        },
        {
          name: 'r_lastdiscipline',
          prop: 'r_lastdiscipline',
          dataType: 'TEXT',
        },
        {
          name: 'nl',
          prop: 'nl',
          dataType: 'INT',
        },
        {
          name: 'certificatetype',
          prop: 'certificatetype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'mobile',
          prop: 'mobile',
          dataType: 'TEXT',
        },
        {
          name: 'pcmprofile',
          prop: 'pcmprofileid',
        },
      {
        name: 'n_zzdzs_like',
        prop: 'n_zzdzs_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pcmprofilename_like',
        prop: 'n_pcmprofilename_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_certificatenumber_like',
        prop: 'n_certificatenumber_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_gender_eq',
        prop: 'n_gender_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_rzqd_eq',
        prop: 'n_rzqd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_yglx_eq',
        prop: 'n_yglx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_r_lastschool_like',
        prop: 'n_r_lastschool_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_xkml_eq',
        prop: 'n_xkml_eq',
        dataType: 'SSCODELIST',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}