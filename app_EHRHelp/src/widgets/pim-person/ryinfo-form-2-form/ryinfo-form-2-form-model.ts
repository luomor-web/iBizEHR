/**
 * RYInfoForm_2 部件模型
 *
 * @export
 * @class RYInfoForm_2Model
 */
export default class RYInfoForm_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof RYInfoForm_2Model
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
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
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
        name: 'srfip_ygbh',
      },
      {
        name: 'srfip_zjlx',
      },
      {
        name: 'srfip_pimpersonname',
      },
      {
        name: 'srfip_zjhm',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'TEXT',
      },
      {
        name: 'zjlx',
        prop: 'zjlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'csrq',
        prop: 'csrq',
        dataType: 'DATE',
      },
      {
        name: 'xb',
        prop: 'xb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'TEXT',
      },
      {
        name: 'nj',
        prop: 'nj',
        dataType: 'INT',
      },
      {
        name: 'zjhm',
        prop: 'zjhm',
        dataType: 'TEXT',
      },
      {
        name: 'xx',
        prop: 'xx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zp',
        prop: 'zp',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'TEXT',
      },
      {
        name: 'dzyx',
        prop: 'dzyx',
        dataType: 'TEXT',
      },
      {
        name: 'hyzk',
        prop: 'hyzk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'mz',
        prop: 'mz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hklx',
        prop: 'hklx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jg',
        prop: 'jg',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hjszd',
        prop: 'hjszd',
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
        name: 'postaladdress',
        prop: 'postaladdress',
        dataType: 'TEXT',
      },
      {
        name: 'sfdszn',
        prop: 'sfdszn',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ahtc',
        prop: 'ahtc',
        dataType: 'TEXT',
      },
      {
        name: 'rcxllx',
        prop: 'rcxllx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimmajorsetypename',
        prop: 'pimmajorsetypename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pcmrcxlname',
        prop: 'pcmrcxlname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zzmm',
        prop: 'zzmm',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rtsj',
        prop: 'rtsj',
        dataType: 'DATE',
      },
      {
        name: 'rdsj',
        prop: 'rdsj',
        dataType: 'DATE',
      },
      {
        name: 'ygzt',
        prop: 'ygzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rzqd',
        prop: 'rzqd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rank',
        prop: 'rank',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zj',
        prop: 'zj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'cjgzsj',
        prop: 'cjgzsj',
        dataType: 'DATE',
      },
      {
        name: 'tozjdate',
        prop: 'tozjdate',
        dataType: 'DATE',
      },
      {
        name: 'dzjbjsj',
        prop: 'dzjbjsj',
        dataType: 'DATE',
      },
      {
        name: 'dbdwsj',
        prop: 'dbdwsj',
        dataType: 'DATE',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'pimperson',
        prop: 'pimpersonid',
        dataType: 'FONTKEY',
      },
    ]
  }

}