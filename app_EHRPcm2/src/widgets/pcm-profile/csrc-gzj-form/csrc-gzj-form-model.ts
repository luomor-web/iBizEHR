/**
 * CSRC_GZJ 部件模型
 *
 * @export
 * @class CSRC_GZJModel
 */
export default class CSRC_GZJModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof CSRC_GZJModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pcmprofileid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmprofilename',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pcmprofileid',
        prop: 'pcmprofileid',
        dataType: 'GUID',
      },
      {
        name: 'cadidateid',
        prop: 'cadidateid',
        dataType: 'TEXT',
      },
      {
        name: 'elinkurl',
        prop: 'elinkurl',
        dataType: 'LONGTEXT',
      },
      {
        name: 'pcmprofilename',
        prop: 'pcmprofilename',
        dataType: 'TEXT',
      },
      {
        name: 'cym',
        prop: 'cym',
        dataType: 'TEXT',
      },
      {
        name: 'certificatetype',
        prop: 'certificatetype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'certificatenumber',
        prop: 'certificatenumber',
        dataType: 'TEXT',
      },
      {
        name: 'birthday',
        prop: 'birthday',
        dataType: 'DATE',
      },
      {
        name: 'nl',
        prop: 'nl',
        dataType: 'INT',
      },
      {
        name: 'gender',
        prop: 'gender',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bloodtype',
        prop: 'bloodtype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zp',
        prop: 'zp',
        dataType: 'LONGTEXT',
      },
      {
        name: 'mobile',
        prop: 'mobile',
        dataType: 'TEXT',
      },
      {
        name: 'email',
        prop: 'email',
        dataType: 'TEXT',
      },
      {
        name: 'wedstate',
        prop: 'wedstate',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nation',
        prop: 'nation',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hklx',
        prop: 'hklx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nativeplace',
        prop: 'nativeplace',
        dataType: 'TEXT',
      },
      {
        name: 'rpr',
        prop: 'rpr',
        dataType: 'SSCODELIST',
      },
      {
        name: 'address',
        prop: 'address',
        dataType: 'TEXT',
      },
      {
        name: 'csd',
        prop: 'csd',
        dataType: 'TEXT',
      },
      {
        name: 'profiletype',
        prop: 'profiletype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'polity',
        prop: 'polity',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yglx',
        prop: 'yglx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'rzqd',
        prop: 'rzqd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pcmprofile',
        prop: 'pcmprofileid',
        dataType: 'FONTKEY',
      },
    ]
  }

}