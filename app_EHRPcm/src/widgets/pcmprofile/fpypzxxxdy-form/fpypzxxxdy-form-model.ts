/**
 * FPYPZXXXDY 部件模型
 *
 * @export
 * @class FPYPZXXXDYModel
 */
export default class FPYPZXXXDYModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof FPYPZXXXDYModel
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
        name: 'sfxzbjnbry',
        prop: 'sfxzbjnbry',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'zp',
        prop: 'zp',
        dataType: 'LONGTEXT',
      },
      {
        name: 'nation',
        prop: 'nation',
        dataType: 'SSCODELIST',
      },
      {
        name: 'wedstate',
        prop: 'wedstate',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bloodtype',
        prop: 'bloodtype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nativeplace',
        prop: 'nativeplace',
        dataType: 'TEXT',
      },
      {
        name: 'hklx',
        prop: 'hklx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rpr',
        prop: 'rpr',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hjdz',
        prop: 'hjdz',
        dataType: 'TEXT',
      },
      {
        name: 'csd',
        prop: 'csd',
        dataType: 'TEXT',
      },
      {
        name: 'address',
        prop: 'address',
        dataType: 'TEXT',
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
        name: 'xznf',
        prop: 'xznf',
        dataType: 'SSCODELIST',
      },
      {
        name: 'profiletype',
        prop: 'profiletype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'workbegindate',
        prop: 'workbegindate',
        dataType: 'DATE',
      },
      {
        name: 'yydj',
        prop: 'yydj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yydjmc',
        prop: 'yydjmc',
        dataType: 'TEXT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'TEXT',
      },
      {
        name: 'polity',
        prop: 'polity',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rdsj',
        prop: 'rdsj',
        dataType: 'DATE',
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
        name: 'gwlb',
        prop: 'gwlb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'napxm',
        prop: 'napxm',
        dataType: 'TEXT',
      },
      {
        name: 'napxmjgwmc',
        prop: 'napxmjgwmc',
        dataType: 'TEXT',
      },
      {
        name: 'gzbt',
        prop: 'gzbt',
        dataType: 'FLOAT',
      },
      {
        name: 'isblacklist',
        prop: 'isblacklist',
        dataType: 'YESNO',
      },
      {
        name: 'isblacklistreason',
        prop: 'isblacklistreason',
        dataType: 'LONGTEXT',
      },
      {
        name: 'sfz',
        prop: 'sfz',
        dataType: 'LONGTEXT',
      },
      {
        name: 'zczs2',
        prop: 'zczs2',
        dataType: 'LONGTEXT',
      },
      {
        name: 'otherfile',
        prop: 'otherfile',
        dataType: 'LONGTEXT',
      },
      {
        name: 'qzsm',
        prop: 'qzsm',
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